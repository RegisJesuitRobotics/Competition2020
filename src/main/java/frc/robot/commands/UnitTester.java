// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class UnitTester extends CommandBase {
  /** Creates a new UnitTester. */
  double units;
  double speed;
  public UnitTester(double units) {
    addRequirements(Robot.m_DriveTrain);
    this.units = units;
    if (units < 0) {
      speed = -0.7;
    } else {
      speed = 0.7;
    }
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_DriveTrain.resetEncoders();
    Robot.m_DriveTrain.arcadeDrive(speed, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_DriveTrain.arcadeDrive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_DriveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (units < 0) {
      return Robot.m_DriveTrain.getAverageEncoderDistance() <= units;
    }
    return Robot.m_DriveTrain.getAverageEncoderDistance() >= units;
  }
}
