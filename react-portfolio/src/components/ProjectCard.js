import React, { useEffect } from 'react';
import styled from 'styled-components';
import ImageWithShimmer from './ImageWithShimmer';

const ProjectImage = styled.div`
  width: 100%;
  overflow: hidden;
  border-radius: 4px;
  transition: transform 0.3s ease;
  
  &:hover {
    transform: scale(1.03);
  }
`;

const ProjectCard = ({ project, forceLoad }) => {
  // Используем уникальный ключ для сброса состояния изображения
  const imageKey = forceLoad ? `${project.id}-${Date.now()}` : project.id;
  
  return (
    <ProjectImage>
      <ImageWithShimmer 
        key={imageKey}
        src={project.imageUrl} 
        alt={project.title || 'Project image'} 
        borderRadius="4px"
        objectFit="cover"
      />
    </ProjectImage>
  );
};

export default ProjectCard; 