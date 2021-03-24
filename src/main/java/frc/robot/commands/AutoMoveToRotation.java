/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class AutoMoveToRotation extends CommandBase {
  /**
   * Creates a new AutoMoveRotate.
   */
  private final double originalSpeed;
  private double speed = 0;
  private final int degrees;

  private final DriveTrain driveTrain;

  public AutoMoveToRotation(int degrees, double speed) {
    addRequirements(Robot.m_DriveTrain);
    this.degrees = toBasicAngle(degrees);
    this.driveTrain = Robot.m_DriveTrain;
    this.originalSpeed = speed;
  }

  private int toBasicAngle(int angle) {
    if (angle < 360 && angle > 0) {
      return angle;
    }
    if (angle > -360 && angle < 0) {
      return 360 + angle;
    }
    SmartDashboard.putNumber("basic angle", angle % 360);
    int newAngle = angle % 360;
    if (newAngle > -360 && newAngle < 0) {
      return 360 + newAngle;
    }
    return newAngle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Gyro: 10
    // Goal: 330
    int basicAngle = toBasicAngle((int) driveTrain.getGyroAngle());
    // BA = 10
    if (basicAngle > degrees) {
      if (basicAngle - degrees <= 180) {
        this.speed = Math.abs(originalSpeed);
      } else {
        this.speed = Math.abs(originalSpeed) * -1;
      }
    } else {
      if (degrees - basicAngle >= 180) {
        this.speed = Math.abs(originalSpeed);
      } else {
        this.speed = Math.abs(originalSpeed) * -1;
      }
    }
    if (Math.abs(toBasicAngle((int) driveTrain.getGyroAngle())) - degrees <= 180) {
      this.speed = Math.abs(originalSpeed);
    } else {
      this.speed = Math.abs(originalSpeed) * -1;
    }
    SmartDashboard.putNumber("spe", speed);
    SmartDashboard.putNumber("degrees", degrees);
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
    // pls dont change this number cause its good at 70% 0.49245
    // return Math.abs(driveTrain.getDifferenceInEncoderDistance()) >= degrees *
    // 0.61;
    double currentGyro = Math.abs(toBasicAngle((int) driveTrain.getGyroAngle()));
    SmartDashboard.putNumber("Current Gyro", currentGyro);
    if (speed > 0) {
      return currentGyro >= degrees;
    }
    return currentGyro <= degrees;
  }
}
