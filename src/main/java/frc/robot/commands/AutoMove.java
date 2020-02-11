/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoMove extends Command {
double m_time, m_leftspeed, m_rightspeed;
  public AutoMove(double time, double lspeed, double rspeed){
    m_time = time;
    m_leftspeed = lspeed;
    m_rightspeed = rspeed;
    requires(Robot.m_DriveTrain);
//requires(Robot.);
  
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  System.out.println("auto driving");
  Robot.m_DriveTrain.setLeftMotorBack(m_leftspeed);
  Robot.m_DriveTrain.setLeftMotorFront(m_leftspeed);
  Robot.m_DriveTrain.setRightMotorBack(m_rightspeed);
  Robot.m_DriveTrain.setRightMotorFront(m_rightspeed);
  setTimeout(m_time);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
  return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_DriveTrain.setLeftMotorBack(0);
    Robot.m_DriveTrain.setLeftMotorFront(0);
    Robot.m_DriveTrain.setRightMotorBack(0);
    Robot.m_DriveTrain.setRightMotorFront(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}