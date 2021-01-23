/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ClimberDeploy extends CommandBase {
  double motorSpeed;
  int direction;
  public ClimberDeploy(double m_motorSpeed, int m_direction) {
    motorSpeed = m_motorSpeed;
    direction = m_direction;
    addRequirements(Robot.m_Climber);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Robot.m_Climber.climberUp(motorSpeed, direction);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.m_Climber.climberUp(motorSpeed, direction);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.m_Climber.climberUp(0, 0);
  }

}
