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
  double m_leftSpeed, m_rightSpeed;

  public AutoMove(double leftSpeed, double rightSpeed) {
    m_leftSpeed = leftSpeed;
    m_rightSpeed = rightSpeed;
    addRequirements(Robot.m_DriveTrain);

  }

  @Override
  public void initialize() {
    System.out.println("auto driving");
  }

  @Override
  public void execute() {
    Robot.m_DriveTrain.tankDrive(m_leftSpeed, m_rightSpeed);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    Robot.m_DriveTrain.setAll(0);
  }

}
