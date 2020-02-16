/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ShooterManual;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Belt extends Command {
  double motorSpeed;
  boolean isUp;
  public Belt(double m_motorSpeed) {
    // Use requires() here to declare subsystem dependencies
    motorSpeed = m_motorSpeed;
    requires(Robot.m_BeltOnly);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_BeltOnly.belt(motorSpeed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_BeltOnly.belt(motorSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_BeltOnly.belt(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
