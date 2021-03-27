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

public class AutoMoveRotate extends CommandBase {
  /**
   * Creates a new AutoMoveRotate.
   */
  private static final double MAGIC_VALUE = 326.8425067836;
  private double speed = 0;
  private final int degrees;
  private double requiredEncoderRotations;

  private final DriveTrain driveTrain;

  public AutoMoveRotate(int degrees, double speed) {
    addRequirements(Robot.m_DriveTrain);
    requiredEncoderRotations = degrees * MAGIC_VALUE;
    if (degrees < 0) {
      speed = speed * -1;
      degrees = degrees * -1;
    }
    this.degrees = degrees;
    this.driveTrain = Robot.m_DriveTrain;
    this.speed = speed;
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
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
    if (speed < 0) {
      return driveTrain.getRightEncoderRotations() < requiredEncoderRotations;
    }
    return driveTrain.getLeftEncoderRotations() > requiredEncoderRotations;
  }
}
