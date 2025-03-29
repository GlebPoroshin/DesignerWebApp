import React from 'react';
import styled from 'styled-components';
import SectionTitle from '../components/SectionTitle';
import SkillBar from '../components/SkillBar';

const SkillsContainer = styled.section`
  padding: 5rem 0;
  
  @media (max-width: 768px) {
    padding: 3rem 0;
  }
`;

const Subtitle = styled.h3`
  font-size: 1.5rem;
  margin-bottom: 2rem;
  color: ${props => props.theme.fourthColor};
  
  @media (max-width: 768px) {
    font-size: 1.25rem;
  }
`;

const ContentWrapper = styled.div`
  display: flex;
  gap: 3rem;
  
  @media (max-width: 768px) {
    flex-direction: column;
  }
`;

const SkillsColumn = styled.div`
  flex: 1;
`;

const ColumnHeader = styled.div`
  margin-bottom: 2rem;
`;

const SoftwareGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2rem;
  
  @media (max-width: 1024px) {
    grid-template-columns: repeat(2, 1fr);
  }
  
  @media (max-width: 576px) {
    grid-template-columns: 1fr;
  }
`;

const SoftwareItem = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
`;

const SoftwareIcon = styled.img`
  width: 64px;
  height: 64px;
  margin-bottom: 1rem;
`;

const SoftwareName = styled.p`
  font-size: 0.9rem;
  color: ${props => props.theme.thirdColor};
`;

const SkillsPage = ({ strings }) => {
  const designSkills = [
    { name: 'UI/UX Design', percentage: 65 },
    { name: 'Graphic Design', percentage: 85 },
    { name: 'Typography', percentage: 85 },
    { name: 'Logo and Branding Design', percentage: 75 },
  ];

  const softwareTools = [
    { name: 'Figma', icon: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/figma_1.png' },
    { name: 'Adobe Photoshop', icon: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_1.png' },
    { name: 'Adobe Illustrator', icon: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_2.png' },
    { name: 'Adobe InDesign', icon: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_3.png' },
    { name: 'Blender', icon: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/3d_1.png' },
    { name: 'After Effects', icon: 'https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_4.png' },
  ];

  return (
    <SkillsContainer id="skills">
      <SectionTitle>{strings.mySkillsHeader}</SectionTitle>
      
      <ContentWrapper>
        <SkillsColumn>
          <ColumnHeader>
            <Subtitle>{strings.mySkills}</Subtitle>
          </ColumnHeader>
          {designSkills.map((skill, index) => (
            <SkillBar 
              key={index}
              name={skill.name}
              percentage={skill.percentage}
            />
          ))}
        </SkillsColumn>
        
        <SkillsColumn>
          <ColumnHeader>
            <Subtitle>{strings.software}</Subtitle>
          </ColumnHeader>
          <SoftwareGrid>
            {softwareTools.map((tool, index) => (
              <SoftwareItem key={index}>
                <SoftwareIcon src={tool.icon} alt={tool.name} />
                <SoftwareName>{tool.name}</SoftwareName>
              </SoftwareItem>
            ))}
          </SoftwareGrid>
        </SkillsColumn>
      </ContentWrapper>
    </SkillsContainer>
  );
};

export default SkillsPage; 