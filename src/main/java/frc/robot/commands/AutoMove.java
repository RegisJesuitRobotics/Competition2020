/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoMove extends CommandBase {
  double m_leftFrontSpeed, m_leftBackSpeed, m_rightFrontSpeed, m_rightBackSpeed;

  public AutoMove(double lfspeed, double lbspeed, double rfspeed, double rbspeed) {
    m_leftFrontSpeed = lfspeed;
    m_leftBackSpeed = lbspeed;
    m_rightFrontSpeed = rfspeed;
    m_rightBackSpeed = rbspeed;
    addRequirements(Robot.m_DriveTrain);

  }

  @Override
  public void initialize() {
    System.out.println("auto driving");
    Robot.m_DriveTrain.setLeftMotorBack(m_leftBackSpeed);
    Robot.m_DriveTrain.setLeftMotorFront(m_leftFrontSpeed);
    Robot.m_DriveTrain.setRightMotorBack(m_rightBackSpeed);
    Robot.m_DriveTrain.setRightMotorFront(m_rightFrontSpeed);
  }

  @Override
  public void execute() {
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    Robot.m_DriveTrain.setLeftMotorBack(0);
    Robot.m_DriveTrain.setLeftMotorFront(0);
    Robot.m_DriveTrain.setRightMotorBack(0);
    Robot.m_DriveTrain.setRightMotorFront(0);
  }

}
