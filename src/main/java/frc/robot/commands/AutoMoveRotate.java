/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;

public class AutoMoveRotate extends CommandBase {
  /**
   * Creates a new AutoMoveRotate.
   */
  private final double desiredSeconds;
  private ParallelDeadlineGroup autoMove;


  public AutoMoveRotate(double degrees, double desiredSeconds) {
    addRequirements(Robot.m_DriveTrain);
    this.desiredSeconds = desiredSeconds;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: This needs to be calculated with the desired seconds
    autoMove = new AutoMove(-0.2, -0.2, 0.2, 0.2).deadlineWith(new WaitCommand(desiredSeconds));
    autoMove.schedule();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    autoMove.cancel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
