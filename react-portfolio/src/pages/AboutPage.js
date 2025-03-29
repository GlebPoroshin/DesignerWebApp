import React from 'react';
import styled from 'styled-components';
import SectionTitle from '../components/SectionTitle';
import Button from '../components/Button';
import ImageWithShimmer from '../components/ImageWithShimmer';

const AboutContainer = styled.section`
  padding: 5rem 0;
  
  @media (max-width: 768px) {
    padding: 3rem 0;
  }
`;

const ContentWrapper = styled.div`
  display: flex;
  gap: 3rem;
  
  @media (max-width: 768px) {
    flex-direction: column;
  }
`;

const TextContent = styled.div`
  flex: 1;
`;

const Subtitle = styled.h3`
  font-size: 1.5rem;
  margin-bottom: 1.5rem;
  color: ${props => props.theme.fourthColor};
  
  @media (max-width: 768px) {
    font-size: 1.25rem;
  }
`;

const Description = styled.p`
  line-height: 1.8;
  margin-bottom: 2rem;
  font-size: 1.1rem;
  color: ${props => props.theme.fourthColor};
  white-space: pre-line;
  text-align: justify;
  
  @media (max-width: 768px) {
    font-size: 1rem;
    text-align: center;
  }
`;

const ImageContent = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: -36px;
  
  @media (max-width: 768px) {
    margin-top: 2rem;
  }
`;

const AboutPage = ({ strings, uriHandler }) => {
  return (
    <AboutContainer id="about">
      <SectionTitle>{strings.aboutMeTitle}</SectionTitle>
      <ContentWrapper>
        <TextContent>
          <Subtitle>{strings.getToKnowMe}</Subtitle>
          <Description>{strings.aboutMe}</Description>
          <Button onClick={() => uriHandler.openUri('/CV.pdf')}>
            {strings.downLoadResume}
          </Button>
        </TextContent>
        <ImageContent>
          <ImageWithShimmer 
            src="https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/sticker.png"
            alt="Lidia Suzdaltseva"
            maxWidth="400px"
            borderRadius="10px"
            objectFit="cover"
            style={{
              marginTop: '-36px',
              marginLeft: '48px'
            }}
          />
        </ImageContent>
      </ContentWrapper>
    </AboutContainer>
  );
};

export default AboutPage; 