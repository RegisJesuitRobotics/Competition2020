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
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX ballIntake, belt, shooterWheels;
  private CANSparkMax aimMotor;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    ballIntake = new TalonSRX(RobotMap.INTAKE_PORT);
    belt = new TalonSRX(RobotMap.BELT_PORT);
    shooterWheels = new TalonSRX(RobotMap.SHOOTER_WHEELS_PORT);
    aimMotor = new CANSparkMax(200, MotorType.kBrushless);
    
  }

  public void shootAndIntake(double motorSpeed, boolean isShooting){
    //Assuming shoot is positive
    motorSpeed = Math.abs(motorSpeed);
    if(!isShooting){
      motorSpeed *= -1;
    }
    shooterWheels.set(ControlMode.PercentOutput, motorSpeed);
  }

  // public void DropIntake(double motorSpeed, boolean isDown){
  //   //Assuming down is positive
  //   motorSpeed = Math.abs(motorSpeed);
  //   if(!isDown){
  //     motorSpeed *= -1;
  //   }
  //   intakeDrop.set(ControlMode.PercentOutput,motorSpeed);
  // }

  public void aim(double motorSpeed, boolean isUp){
    //assuming up is positive
    motorSpeed = Math.abs(motorSpeed);
    if(!isUp){
      motorSpeed *= -1;
    }
    aimMotor.set(motorSpeed);
  }

  public void belt(double motorSpeed, boolean isIn){
    //assuming belt moving in is positive
    motorSpeed = Math.abs(motorSpeed);
    if(!isIn){
      motorSpeed *= -1;
    }
    belt.set(ControlMode.PercentOutput,motorSpeed);
  }

  public void intake(double motorSpeed, boolean isIn){
    //assuming in is positive
    motorSpeed = Math.abs(motorSpeed);
    if(!isIn){
      motorSpeed *= -1;
    }
    ballIntake.set(ControlMode.PercentOutput,motorSpeed);    
  }
}