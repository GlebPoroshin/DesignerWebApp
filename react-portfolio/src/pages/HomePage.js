import React from 'react';
import styled from 'styled-components';
import Button from '../components/Button';
import ImageWithShimmer from '../components/ImageWithShimmer';

const HomeContainer = styled.section`
  min-height: 80vh;
  display: flex;
  align-items: center;
  
  @media (max-width: 768px) {
    flex-direction: column;
    text-align: center;
    padding: 2rem 0;
  }
`;

const ContentContainer = styled.div`
  flex: 1;
  padding-right: 2rem;
  
  @media (max-width: 768px) {
    padding-right: 0;
    margin-bottom: 2rem;
  }
`;

const ImageContainer = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  
  @media (max-width: 768px) {
    width: 100%;
  }
`;

const NameHeading = styled.h1`
  font-size: 3rem;
  font-weight: 700;
  margin-bottom: 0.5rem;
  color: ${props => props.theme.thirdColor};
  
  @media (max-width: 768px) {
    font-size: 2.5rem;
  }
`;

const Profession = styled.h2`
  font-size: 1.5rem;
  font-weight: 500;
  margin-bottom: 1.5rem;
  color: ${props => props.theme.fourthColor};
  
  @media (max-width: 768px) {
    font-size: 1.25rem;
  }
`;

const Description = styled.p`
  font-size: 1.1rem;
  margin-bottom: 2rem;
  line-height: 1.6;
  color: ${props => props.theme.fourthColor};
  max-width: 600px;
  text-align: justify;
  
  @media (max-width: 768px) {
    font-size: 1rem;
    text-align: center;
  }
`;

const ButtonContainer = styled.div`
  display: flex;
  gap: 1rem;
  
  @media (max-width: 768px) {
    justify-content: center;
  }
`;

const HomePage = ({ strings, uriHandler }) => {
  const handleContactClick = () => {
    document.getElementById('contacts').scrollIntoView({ behavior: 'smooth' });
  };

  return (
    <HomeContainer id="home">
      <ContentContainer>
        <NameHeading>{strings.name}</NameHeading>
        <Profession>{strings.profession}</Profession>
        <Description>{strings.shortDescription}</Description>
        <ButtonContainer>
          <Button primary onClick={handleContactClick}>
            {strings.contactMe}
          </Button>
        </ButtonContainer>
      </ContentContainer>
      <ImageContainer>
        <ImageWithShimmer
          src="https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/react/composeApp/src/commonMain/composeResources/drawable/emoji.png"
          alt="Emoji Sticker"
          width="240px"
          height="240px"
          objectFit="contain"
        />
      </ImageContainer>
    </HomeContainer>
  );
};

export default HomePage; 