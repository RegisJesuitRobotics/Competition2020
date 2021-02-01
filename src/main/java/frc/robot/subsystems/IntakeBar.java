/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import frc.robot.RobotMap;

public class IntakeBar extends SubsystemBase {
  private CANSparkMax intakeSparkMax = new CANSparkMax(RobotMap.INTAKE_BAR_PORT, MotorType.kBrushless);
  private DoubleSolenoid intakeSolenoid = new DoubleSolenoid(1, 2);

  public void intakeRun(double motorSpeed) {
    intakeSparkMax.set(motorSpeed);
  }

  public void intakeMove(int direction) {
    if (direction == -1) {
    //  System.out.println("reverse");
      intakeSolenoid.set(kReverse);
    } else if (direction == 1) {
    //  System.out.println("forward");
      intakeSolenoid.set(kForward);
    } else if (direction == 0) {
      intakeSolenoid.set(kOff);

    }
  }
}
