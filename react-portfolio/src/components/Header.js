import React from 'react';
import styled from 'styled-components';

const HeaderContainer = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem 0;
  width: 100%;
  
  @media (max-width: 768px) {
    flex-direction: column;
    gap: 1rem;
  }
`;

const Logo = styled.div`
  font-size: 1.5rem;
  font-weight: bold;
`;

const Nav = styled.nav`
  display: flex;
  gap: 2rem;
  
  @media (max-width: 768px) {
    gap: 1rem;
    width: 100%;
    justify-content: space-between;
  }
`;

const NavItem = styled.button`
  background: none;
  color: ${props => props.theme.thirdColor};
  font-size: 1rem;
  padding: 0.5rem;
  position: relative;
  
  &:after {
    content: '';
    position: absolute;
    width: 0;
    height: 2px;
    bottom: 0;
    left: 0;
    background-color: ${props => props.theme.thirdColor};
    transition: width 0.3s;
  }
  
  &:hover:after,
  &.active:after {
    width: 100%;
  }
`;

const ControlsContainer = styled.div`
  display: flex;
  gap: 1rem;
  align-items: center;
`;

const LanguageToggle = styled.button`
  background: none;
  padding: 0.5rem;
  color: ${props => props.theme.thirdColor};
  font-weight: bold;
`;

const ThemeToggle = styled.button`
  background: ${props => props.isBlackTheme ? props.theme.thirdColor : props.theme.fourthColor};
  color: ${props => props.isBlackTheme ? props.theme.mainColor : props.theme.mainColor};
  border-radius: 50%;
  width: 40px;
  height: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Header = ({ 
  isEnglish, 
  onLanguageChange, 
  contentsNamesList, 
  onPageChange, 
  isBlackTheme, 
  onThemeChange,
  currentPage
}) => {
  return (
    <HeaderContainer>
      <Logo>LS.</Logo>
      
      <Nav>
        {contentsNamesList.map((name, index) => (
          <NavItem 
            key={index} 
            onClick={() => onPageChange(index)}
            className={currentPage === index ? 'active' : ''}
          >
            {name}
          </NavItem>
        ))}
      </Nav>
      
      <ControlsContainer>
        <LanguageToggle onClick={onLanguageChange}>
          {isEnglish ? 'EN' : 'RU'}
        </LanguageToggle>
        
        <ThemeToggle
          isBlackTheme={isBlackTheme}
          onClick={onThemeChange}
        >
          {isBlackTheme ? '☀️' : '🌙'}
        </ThemeToggle>
      </ControlsContainer>
    </HeaderContainer>
  );
};

export default Header; 