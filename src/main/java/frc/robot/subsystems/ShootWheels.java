/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;


/**
 * Add your docs here.
 */
public class ShootWheels extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX ballIntake, belt, shooterWheelLeft, shooterWheelRight;
  private CANSparkMax aimMotor;

  @Override
  public void initDefaultCommand() {
    shooterWheelLeft = new TalonSRX(RobotMap.SHOOTER_WHEELS_PORT_LEFT);
    shooterWheelRight = new TalonSRX(RobotMap.SHOOTER_WHEELS_PORT_RIGHT);
    
  }

  public void shootAndIntake(double motorSpeed){
    
    shooterWheelLeft.set(ControlMode.PercentOutput, motorSpeed);
    shooterWheelRight.set(ControlMode.PercentOutput, -motorSpeed);
    System.out.println("Shooting/Intaking");
  }

  

  // public void intake(double motorSpeed, boolean isIn){
  //   //assuming in is positive
  //   motorSpeed = Math.abs(motorSpeed);
  //   if(!isIn){
  //     motorSpeed *= -1;
  //   }
  //   ballIntake.set(ControlMode.PercentOutput,motorSpeed);    
  // }
}