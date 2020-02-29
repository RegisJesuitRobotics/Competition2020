/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
  DoubleSolenoid climberSolenoid;
  CANSparkMax climberMotor;
  TalonSRX climberSide;


  @Override
  public void initDefaultCommand() {
    climberSolenoid = new DoubleSolenoid(5, 6);
    climberMotor = new CANSparkMax(420, MotorType.kBrushless);
    climberSide = new TalonSRX(69);
  }

  public void sideClimb(double speed) {
    climberSide.set(ControlMode.PercentOutput, speed);
  }

  public void moveClimber(double climberSpeed){
    climberMotor.set(climberSpeed);

  }

  public void setClimberSolenoid(int direction) {
    {

      if (direction == 1) {
        climberSolenoid.set(kForward);
        System.out.println("up");

      }

      else if (direction == -1) {
        climberSolenoid.set(kReverse);
        System.out.println("down");

      } else if (direction == 0) {
        climberSolenoid.set(kOff);
        System.out.println("off");

      }
    }
  }
}
