 /*----------------------------------------------------------------------------*/
 /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
 /* Open Source Software - may be modified and shared by FRC teams. The code   */
 /* must be accompanied by the FIRST BSD license file in the root directory of */
 /* the project.                                                               */
 /*----------------------------------------------------------------------------*/

 package frc.robot.commands.ColorWheelStuff;

 import edu.wpi.first.wpilibj2.command.CommandBase;
 import frc.robot.Robot;

 public class ColorWheelSpin extends CommandBase {
     double m_spinSpeed;

     public ColorWheelSpin(double spinSpeed) {
         m_spinSpeed = spinSpeed;
         addRequirements(Robot.m_ColorWheel);
     }

     @Override
     public void initialize() {
     }

     @Override
     public void execute() {
         Robot.m_ColorWheel.spinMotor(m_spinSpeed);
     }

     @Override
     public boolean isFinished() {
         return false;
     }

     @Override
     public void end(boolean interrupted) {
         Robot.m_ColorWheel.spinMotor(0);
     }

 }
