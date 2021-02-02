/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ShooterManual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Enums;
import frc.robot.Robot;

public class IntakeDrop extends CommandBase {
  Enums.IntakeDirection direction;
  public IntakeDrop(Enums.IntakeDirection m_direction) {
    // Use requires() here to declare subsystem dependencies
    addRequirements(Robot.m_UpAndDown);
    direction = m_direction;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    Robot.m_IntakeBar.intakeMove(direction);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.m_IntakeBar.intakeMove(Enums.IntakeDirection.STOP);
  }
}
