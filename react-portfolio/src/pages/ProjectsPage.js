import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import SectionTitle from '../components/SectionTitle';
import Button from '../components/Button';
import ProjectCard from '../components/ProjectCard';

const ProjectsContainer = styled.section`
  padding: 5rem 0;
  
  @media (max-width: 768px) {
    padding: 3rem 0;
  }
`;

const Subtitle = styled.h3`
  font-size: 1.5rem;
  margin-bottom: 2rem;
  color: ${props => props.theme.fourthColor};
  text-align: center;
  
  @media (max-width: 768px) {
    font-size: 1.25rem;
  }
`;

const TabsContainer = styled.div`
  display: flex;
  gap: 1rem;
  margin: 2rem 0 4rem;
  justify-content: center;
  
  @media (max-width: 576px) {
    flex-direction: column;
    align-items: center;
  }
`;

const ProjectsGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(${props => props.columns}, 1fr);
  gap: 2rem;
  margin-bottom: 3rem;
  
  @media (max-width: 1024px) {
    grid-template-columns: repeat(2, 1fr);
  }
  
  @media (max-width: 576px) {
    grid-template-columns: 1fr;
  }
`;

const ButtonContainer = styled.div`
  display: flex;
  justify-content: center;
  margin-bottom: 2rem;
`;

const ProjectsPage = ({ strings }) => {
  const [activeTab, setActiveTab] = useState('Adobe');
  const [isExpanded, setIsExpanded] = useState(false);
  const [displayedProjects, setDisplayedProjects] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  
  const tabConfig = {
    'Adobe': { initialCount: 3, columns: 3 },
    'Figma': { initialCount: 2, columns: 2 },
    '3D': { initialCount: 2, columns: 2 }
  };
  
  const figmaProjects = [
    { id: 1, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/figma_1.png' },
    { id: 2, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/figma_2.png' },
    { id: 3, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/figma_3.png' },
    { id: 4, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/figma_4.png' },
    { id: 5, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/figma_5.png' },
  ];
  
  const adobeProjects = [
    { id: 1, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_1.png' },
    { id: 2, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_2.png' },
    { id: 3, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_3.png' },
    { id: 4, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_4.png' },
    { id: 5, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_5.png' },
    { id: 6, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_6.png' },
    { id: 7, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_7.png' },
    { id: 8, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_8.png' },
    { id: 9, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_9.png' },
    { id: 12, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_12.png' },
    { id: 13, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_13.png' },
    { id: 14, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_14.png' },
    { id: 15, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/adobe_15.png' },
    ];
  
  const threeDProjects = [
    { id: 1, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/3d_1.png' },
    { id: 2, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/3d_2.png' },
    { id: 3, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/3d_3.png' },
    { id: 4, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/3d_4.png' },
    { id: 5, imageUrl: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/3d_5.png' },
  ];
  
  const projectsByTab = {
    'Adobe': adobeProjects,
    'Figma': figmaProjects,
    '3D': threeDProjects
  };
  
  useEffect(() => {
    const projects = projectsByTab[activeTab] || [];
    const count = isExpanded ? projects.length : tabConfig[activeTab].initialCount;
    
    if (isExpanded && projects.length > tabConfig[activeTab].initialCount) {
      // Если переключаемся в режим "Показать все" и есть дополнительные проекты
      setIsLoading(true);
      
      // Сначала показываем только первые проекты
      setDisplayedProjects(projects.slice(0, tabConfig[activeTab].initialCount));
      
      // Имитируем загрузку изображений
      setTimeout(() => {
        setDisplayedProjects(projects.slice(0, count));
        setIsLoading(false);
      }, 300);
    } else {
      // В других случаях просто обновляем список проектов
      setDisplayedProjects(projects.slice(0, count));
    }
  }, [activeTab, isExpanded]);
  
  const handleTabChange = (tab) => {
    setActiveTab(tab);
    setIsExpanded(false);
  };
  
  const toggleExpand = () => {
    setIsExpanded(!isExpanded);
  };
  
  return (
    <ProjectsContainer id="projects">
      <SectionTitle>{strings.projects}</SectionTitle>
      <Subtitle>{strings.myWorks}</Subtitle>
      
      <TabsContainer>
        {Object.keys(tabConfig).map(tab => (
          <Button 
            key={tab}
            primary={activeTab === tab}
            onClick={() => handleTabChange(tab)}
            style={{ minWidth: '140px' }}
          >
            {tab}
          </Button>
        ))}
      </TabsContainer>
      
      <ProjectsGrid columns={tabConfig[activeTab].columns}>
        {displayedProjects.map(project => (
          <ProjectCard 
            key={project.id} 
            project={project}
            forceLoad={isLoading} 
          />
        ))}
      </ProjectsGrid>
      
      <ButtonContainer>
        <Button onClick={toggleExpand} disabled={isLoading}>
          {isExpanded ? strings.hide : strings.view}
        </Button>
      </ButtonContainer>
    </ProjectsContainer>
  );
};

export default ProjectsPage; 