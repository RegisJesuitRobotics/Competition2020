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
  double m_time, m_leftFrontSpeed, m_leftBackSpeed, m_rightFrontSpeed, m_rightBackSpeed;

  public AutoMove(double lfspeed, double lbspeed, double rfspeed, double rbspeed, double time) {
    m_time = time;
    m_leftFrontSpeed = lfspeed;
    m_leftBackSpeed = lbspeed;
    m_rightFrontSpeed = rfspeed;
    m_rightBackSpeed = rbspeed;
    requires(Robot.m_DriveTrain);

  }

  @Override
  protected void initialize() {
    System.out.println("auto driving");
    Robot.m_DriveTrain.setLeftMotorBack(m_leftBackSpeed);
    Robot.m_DriveTrain.setLeftMotorFront(m_leftFrontSpeed);
    Robot.m_DriveTrain.setRightMotorBack(m_rightBackSpeed);
    Robot.m_DriveTrain.setRightMotorFront(m_rightFrontSpeed);
    setTimeout(m_time);
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    Robot.m_DriveTrain.setLeftMotorBack(0);
    Robot.m_DriveTrain.setLeftMotorFront(0);
    Robot.m_DriveTrain.setRightMotorBack(0);
    Robot.m_DriveTrain.setRightMotorFront(0);
  }

  @Override
  protected void interrupted() {
    this.end();
  }
}
