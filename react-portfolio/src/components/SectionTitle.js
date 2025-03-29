import React from 'react';
import styled from 'styled-components';

const Title = styled.h2`
  font-size: 2.5rem;
  font-weight: 700;
  margin-bottom: 2rem;
  position: relative;
  color: ${props => props.theme.thirdColor};
  text-align: left;
  
  &:after {
    content: '';
    position: absolute;
    width: 60px;
    height: 3px;
    background-color: ${props => props.theme.thirdColor};
    bottom: -10px;
    left: 0;
  }
  
  @media (max-width: 768px) {
    font-size: 2rem;
    text-align: center;
    
    &:after {
      left: 50%;
      transform: translateX(-50%);
    }
  }
`;

const SectionTitle = ({ children }) => {
  return <Title>{children}</Title>;
};

export default SectionTitle; 