/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class AutoMoveRotate extends CommandBase {
  /**
   * Creates a new AutoMoveRotate.
   */
  private final double speed;
  private final int degrees;

  private final DriveTrain driveTrain;


  public AutoMoveRotate(int degrees, double speed) {
    addRequirements(Robot.m_DriveTrain);
    this.speed = speed;
    this.degrees = degrees;
    this.driveTrain = Robot.m_DriveTrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(0, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // TODO Calculate distance rotated based on incehs calculated by encoders
    return false;
  }
}
