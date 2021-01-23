/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class UpAndDown extends SubsystemBase {

  private TalonSRX aimMotor = new TalonSRX(RobotMap.ADJUST_PORT);

  public void aim(double motorSpeed) {

    aimMotor.set(ControlMode.PercentOutput, motorSpeed);
  }

}