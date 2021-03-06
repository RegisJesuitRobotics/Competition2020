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

/**
 * Add your docs here.
 */
public class ShootWheels extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX shooterWheelLeft = new TalonSRX(RobotMap.SHOOTER_WHEELS_PORT_LEFT);
  private TalonSRX shooterWheelRight = new TalonSRX(RobotMap.SHOOTER_WHEELS_PORT_RIGHT);

  public void shootAndIntake(double motorSpeed) {

    shooterWheelLeft.set(ControlMode.PercentOutput, motorSpeed);
    shooterWheelRight.set(ControlMode.PercentOutput, -motorSpeed);
  //  System.out.println("Shooting/Intaking");
  }

}