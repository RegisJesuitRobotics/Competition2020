/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ShooterManual;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ShooterShoot extends Command {
  double motorSpeed;
  boolean isIn;
  public ShooterShoot(double m_motorSpeed, boolean m_isIn) {
    // Use requires() here to declare subsystem dependencies
    motorSpeed = m_motorSpeed;
    isIn = m_isIn;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_Shooter.shootAndIntake(motorSpeed, isIn);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    Robot.m_Shooter.shootAndIntake(0, true);
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
