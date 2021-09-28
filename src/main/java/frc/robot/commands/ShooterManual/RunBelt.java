/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ShooterManual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class RunBelt extends CommandBase {
  double motorSpeed;
  boolean isUp;
  public RunBelt(double m_motorSpeed) {
    // Use requires() here to declare subsystem dependencies
    motorSpeed = m_motorSpeed;
    addRequirements(Robot.m_Belt);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Robot.m_Belt.belt(motorSpeed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.m_Belt.belt(motorSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.m_Belt.belt(0);
  }

}