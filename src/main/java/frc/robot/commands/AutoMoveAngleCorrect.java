// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.utils.Util;

public class AutoMoveAngleCorrect extends CommandBase {

  private final DriveTrain driveTrain;
  private final double originalSpeed;
  private final double toAngle;
  private final int offset = 1;
  private double actualSpeed;
  private double robotBeginningDegrees;
  private boolean dontrun = false;

  public AutoMoveAngleCorrect(int toAngle, double speed) {
    addRequirements(Robot.m_DriveTrain);
    this.driveTrain = Robot.m_DriveTrain;
    this.originalSpeed = Math.abs(speed);
    this.toAngle = toAngle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    robotBeginningDegrees = driveTrain.getGyroHeading();
    System.out.println("THING" + ((Double) robotBeginningDegrees).toString());
    SmartDashboard.putNumber("O ANgle", robotBeginningDegrees);
    SmartDashboard.putNumber("To Angle", toAngle);
    if (toAngle + 0.25 >= robotBeginningDegrees && toAngle - 0.25 <= robotBeginningDegrees) {
      System.out.println("Canceling");
      dontrun = true;
    } else {
      actualSpeed = originalSpeed * (Util.getFastestDirection(robotBeginningDegrees, toAngle));
      SmartDashboard.putNumber("Speed", actualSpeed);
      driveTrain.arcadeDrive(0, actualSpeed);
    }
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
    if (dontrun) {
      return true;
    }
    SmartDashboard.putNumber("Last", driveTrain.getGyroHeading());
    if (actualSpeed < 0) {
      return !Util.isInAngleRange(toAngle + offset, robotBeginningDegrees, driveTrain.getGyroHeading());
    }
    return !Util.isInAngleRange(robotBeginningDegrees, toAngle - offset, driveTrain.getGyroHeading());
  }
}
