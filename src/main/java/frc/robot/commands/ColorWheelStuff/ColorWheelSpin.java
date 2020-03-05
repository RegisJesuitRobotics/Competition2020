/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ColorWheelStuff;

import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ColorWheelSpin extends Command {
  double m_spinSpeed;

  public ColorWheelSpin(double spinSpeed) {
    m_spinSpeed = spinSpeed;
    requires(Robot.m_ColorWheel);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
  Robot.m_ColorWheel.spinMotor(m_spinSpeed);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  Robot.m_ColorWheel.spinMotor(0);
  }

  @Override
  protected void interrupted() {
  this.end();
  }
}
