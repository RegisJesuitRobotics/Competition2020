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


/**
 * Add your docs here.
 */
public class BeltOnly extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX belt;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
    belt = new TalonSRX(RobotMap.BELT_PORT);
    
    
  }

  // public void shootAndIntake(double motorSpeed){
    
  //   shooterWheelLeft.set(ControlMode.PercentOutput, motorSpeed);
  //   shooterWheelRight.set(ControlMode.PercentOutput, motorSpeed);
  //   System.out.println("Shooting/Intaking");
  // }

  // public void DropIntake(double motorSpeed, boolean isDown){
  //   //Assuming down is positive
  //   motorSpeed = Math.abs(motorSpeed);
  //   if(!isDown){
  //     motorSpeed *= -1;
  //   }
  //   intakeDrop.set(ControlMode.PercentOutput,motorSpeed);
  // }

 

  public void belt(double motorSpeed){
   
    belt.set(ControlMode.PercentOutput,motorSpeed);
  }

  
}