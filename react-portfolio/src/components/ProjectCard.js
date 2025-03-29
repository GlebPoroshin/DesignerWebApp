import React from 'react';
import styled from 'styled-components';
import ImageWithShimmer from './ImageWithShimmer';

const ProjectImage = styled.div`
  width: 100%;
  max-width: 100%;
  overflow: hidden;
  border-radius: 4px;
  transition: transform 0.3s ease;
  grid-column: ${props => props.isLastItem ? `1 / span ${props.gridColumns}` : 'auto'};
  display: flex;
  justify-content: center;
  
  &:hover {
    transform: scale(1.03);
  }
`;

const StyledImageWithShimmer = styled(ImageWithShimmer)`
  width: 100%;
  max-width: ${props => props.isLastItem ? '50%' : '100%'};
  
  @media (max-width: 768px) {
    max-width: 100%;
  }
`;

const ProjectCard = ({ project, forceLoad, className, isLastItem, gridColumns }) => {
  // Используем уникальный ключ для сброса состояния изображения
  const imageKey = forceLoad ? `${project.id}-${Date.now()}` : project.id;
  
  return (
    <ProjectImage 
      className={className}
      isLastItem={isLastItem}
      gridColumns={gridColumns}
    >
      <StyledImageWithShimmer 
        key={imageKey}
        src={project.imageUrl} 
        alt={project.title || 'Project image'} 
        borderRadius="4px"
        objectFit="cover"
        width="100%"
        isLastItem={isLastItem}
      />
    </ProjectImage>
  );
};

export default ProjectCard; 