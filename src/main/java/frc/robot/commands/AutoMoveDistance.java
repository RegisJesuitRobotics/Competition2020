/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class AutoMoveDistance extends CommandBase {
  /**
   * Creates a new AutoMoveDistance.
   */

  public static List<Double> startingDistances = new ArrayList<Double>();
  public static List<Double> endingDistances = new ArrayList<Double>();


  private final double speed;
  private final DriveTrain driveTrain;
  private final double requiredUnits;

  public AutoMoveDistance(int inches, double speed) {
    addRequirements(Robot.m_DriveTrain);
    this.driveTrain = Robot.m_DriveTrain;
    inches = (int) (inches / 0.852);
    if (inches < 0) {
      inches = Math.abs(inches);
      speed = speed * -1;
    }
    this.requiredUnits = inches * 909.090;
    this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetEncoders();
    driveTrain.arcadeDrive(speed, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0);
    SmartDashboard.putNumber("End Value", driveTrain.getAverageEncoderDistance());
    driveTrain.resetEncoders();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(driveTrain.getAverageEncoderDistance()) >= requiredUnits;
  }
}
