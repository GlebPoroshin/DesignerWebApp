import React from 'react';
import styled from 'styled-components';

const StyledButton = styled.button`
  background-color: ${props => props.primary ? props.theme.thirdColor : 'transparent'};
  color: ${props => props.primary ? props.theme.mainColor : props.theme.thirdColor};
  border: 1px solid ${props => props.theme.thirdColor};
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
  
  &:hover {
    background-color: ${props => props.primary ? props.theme.fourthColor : props.theme.secondaryColor};
  }
  
  @media (max-width: 768px) {
    padding: 0.5rem 1rem;
    font-size: 0.9rem;
  }
`;

const Button = ({ children, primary, onClick, ...rest }) => {
  return (
    <StyledButton primary={primary} onClick={onClick} {...rest}>
      {children}
    </StyledButton>
  );
};

export default Button; 