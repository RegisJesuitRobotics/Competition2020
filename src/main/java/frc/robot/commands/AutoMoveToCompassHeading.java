// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.utils.Util;

public class AutoMoveToCompassHeading extends CommandBase {

  private final DriveTrain driveTrain;
  private final double originalSpeed;
  private final double toHeading;
  private final int offset = 1;
  private double actualSpeed;
  private double robotBeginningDegrees;

  public AutoMoveToCompassHeading(int toHeading, double speed) {
    addRequirements(Robot.m_DriveTrain);
    this.driveTrain = Robot.m_DriveTrain;
    this.originalSpeed = Math.abs(speed);
    this.toHeading = toHeading;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Starting");
    robotBeginningDegrees = driveTrain.getCompassHeading();
      actualSpeed = originalSpeed * (Util.getFastestDirection(robotBeginningDegrees, toHeading));
      driveTrain.arcadeDrive(0, actualSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(0, actualSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (actualSpeed < 0) {
      return !Util.isInAngleRange(toHeading + offset, robotBeginningDegrees, driveTrain.getCompassHeading());
    }
    return !Util.isInAngleRange(robotBeginningDegrees, toHeading - offset, driveTrain.getCompassHeading());
  }
}
