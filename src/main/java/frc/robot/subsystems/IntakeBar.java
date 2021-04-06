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

import frc.robot.Enums;
import frc.robot.RobotMap;
import frc.robot.Enums.IntakeDirection;

public class IntakeBar extends SubsystemBase {
  private CANSparkMax intakeSparkMax = new CANSparkMax(RobotMap.INTAKE_BAR_PORT, MotorType.kBrushless);
  private DoubleSolenoid intakeSolenoid = new DoubleSolenoid(1, 2);

  public void intakeRun(double motorSpeed) {
    intakeSparkMax.set(motorSpeed);
  }

  public void releaseIntakeMove() {
    intakeMove(IntakeDirection.REVERSE);
  }

  public void intakeMove(Enums.IntakeDirection direction) {
    if (direction == Enums.IntakeDirection.REVERSE) {
    //  System.out.println("reverse");
      intakeSolenoid.set(kReverse);
    } else if (direction == Enums.IntakeDirection.FORWARD) {
    //  System.out.println("forward");
      intakeSolenoid.set(kForward);
    } else if (direction == Enums.IntakeDirection.STOP) {
      intakeSolenoid.set(kOff);

    }
  }
}
