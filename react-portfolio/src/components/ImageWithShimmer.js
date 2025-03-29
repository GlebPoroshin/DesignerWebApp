import React, { useState, useEffect } from 'react';
import styled, { keyframes } from 'styled-components';

const shimmer = keyframes`
  0% {
    background-position: -200% 0;
  }
  100% {
    background-position: 200% 0;
  }
`;

const ImageContainer = styled.div`
  position: relative;
  width: ${props => props.width || '100%'};
  height: ${props => props.height || 'auto'};
  max-width: ${props => props.maxWidth || 'none'};
  max-height: ${props => props.maxHeight || 'none'};
  overflow: hidden;
  border-radius: ${props => props.borderRadius || '0'};
`;

const ShimmerEffect = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    90deg,
    ${props => props.theme.secondaryColor} 25%,
    ${props => props.theme.accentColor} 50%,
    ${props => props.theme.secondaryColor} 75%
  );
  background-size: 200% 100%;
  animation: ${shimmer} 1.5s infinite linear;
  z-index: ${props => (props.isLoaded ? -1 : 1)};
  opacity: ${props => (props.isLoaded ? 0 : 1)};
  transition: opacity 0.3s ease;
`;

const StyledImage = styled.img`
  width: 100%;
  height: 100%;
  object-fit: ${props => props.objectFit || 'cover'};
  opacity: ${props => (props.isLoaded ? 1 : 0)};
  transition: opacity 0.3s ease;
  display: block;
`;

const ImageWithShimmer = ({
  src,
  alt,
  width,
  height,
  maxWidth,
  maxHeight,
  objectFit,
  borderRadius,
  style,
  className,
  ...props
}) => {
  const [isLoaded, setIsLoaded] = useState(false);
  const [imgSrc, setImgSrc] = useState(null);

  useEffect(() => {
    // Сбрасываем состояние загрузки при изменении src
    setIsLoaded(false);
    
    // Предзагрузка изображения
    const img = new Image();
    img.onload = () => {
      setImgSrc(src);
      setIsLoaded(true);
    };
    img.onerror = () => {
      console.error('Failed to load image:', src);
    };
    img.src = src;

    return () => {
      img.onload = null;
      img.onerror = null;
    };
  }, [src]);

  return (
    <ImageContainer 
      width={width}
      height={height}
      maxWidth={maxWidth}
      maxHeight={maxHeight}
      borderRadius={borderRadius}
      style={style}
      className={className}
    >
      <ShimmerEffect isLoaded={isLoaded} />
      {imgSrc && (
        <StyledImage
          src={imgSrc}
          alt={alt}
          isLoaded={isLoaded}
          objectFit={objectFit}
          {...props}
        />
      )}
    </ImageContainer>
  );
};

export default ImageWithShimmer; 