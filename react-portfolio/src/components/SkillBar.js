import React from 'react';
import styled from 'styled-components';

const SkillBarContainer = styled.div`
  margin-bottom: 1.5rem;
`;

const SkillName = styled.p`
  font-size: 1rem;
  margin-bottom: 0.5rem;
  font-weight: 500;
  color: ${props => props.theme.thirdColor};
`;

const ProgressContainer = styled.div`
  width: 100%;
  height: 10px;
  background-color: ${props => props.theme.secondaryColor};
  border-radius: 5px;
  overflow: hidden;
`;

const ProgressBar = styled.div`
  height: 100%;
  background-color: ${props => props.theme.fourthColor};
  width: ${props => props.percentage}%;
  border-radius: 5px;
  transition: width 1s ease-in-out;
`;

const SkillBar = ({ name, percentage }) => {
  return (
    <SkillBarContainer>
      <SkillName>{name}</SkillName>
      <ProgressContainer>
        <ProgressBar percentage={percentage} />
      </ProgressContainer>
    </SkillBarContainer>
  );
};

export default SkillBar; 