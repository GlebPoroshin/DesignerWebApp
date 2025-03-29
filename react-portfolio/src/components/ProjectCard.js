import React from 'react';
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

const ProjectCard = ({ project }) => {
  return (
    <ProjectImage>
      <ImageWithShimmer 
        src={project.imageUrl} 
        alt={project.title || 'Project image'} 
        borderRadius="4px"
        objectFit="cover"
      />
    </ProjectImage>
  );
};

export default ProjectCard; 