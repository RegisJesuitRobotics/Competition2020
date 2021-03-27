// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class AutoMoveGyro extends CommandBase {
  private double speed = 0;
  private final int degrees;
  private int targetDegrees;
  private int originalGyro;
  private boolean pastZero;

  private final DriveTrain driveTrain;

  public AutoMoveGyro(int degrees, double speed) {
    addRequirements(Robot.m_DriveTrain);
    if (degrees < 0) {
      speed = speed * -1;
      degrees = degrees * -1;
    }
    this.degrees = degrees;
    this.driveTrain = Robot.m_DriveTrain;
    this.speed = speed;
  }

  private int toBasicAngle(int angle) {
    if (angle < 360 && angle > 0) {
      return angle;
    }
    if (angle > -360 && angle < 0) {
      return 360 + angle;
    }
    int newAngle = angle % 360;
    if (newAngle > -360 && newAngle < 0) {
      return 360 + newAngle;
    }
    return newAngle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    targetDegrees = toBasicAngle(((int)driveTrain.getGyroAngle()) + degrees);
    pastZero = targetDegrees != ((int)driveTrain.getGyroAngle()) + degrees;
    originalGyro = (int) driveTrain.getGyroAngle();
    System.out.println(targetDegrees);
    driveTrain.arcadeDrive(0, speed);
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
    double currentGyro = (int) driveTrain.getGyroAngle();
    if (speed > 0) {
      return currentGyro >= targetDegrees && currentGyro <= targetDegrees + 5; 
    } else {
      return currentGyro <= targetDegrees && currentGyro >= targetDegrees + -5;
    }
  }
}
