/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ColorWheel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX colorWheelMotor;

  @Override

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    TalonSRX motor = new TalonSRX(RobotMap.COLOR_WHEEL_MOTOR_PORT);
  }

  public void spinMotor(double spinSpeed, boolean isRight) {
    spinSpeed = Math.abs(spinSpeed);

    if (!isRight) {
      spinSpeed *= -1;
    }
    
    colorWheelMotor.set(ControlMode.PercentOutput, spinSpeed);
  }
}
