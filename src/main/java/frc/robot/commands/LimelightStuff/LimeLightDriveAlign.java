/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightStuff;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LimeLightDriveAlign extends Command {
  int m_defaultDirection;
  public LimeLightDriveAlign(int defaultDirection) {
    m_defaultDirection = defaultDirection;
    // Use requires() here to declare subsystem dependencies align
    // eg. requires(chassis);

    requires(Robot.m_DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    NetworkTable table = instance.getTable("limelight-limeboi");
    NetworkTable fms = instance.getTable("FMSInfo");
    NetworkTableEntry g = fms.getEntry("StationNumber");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry tv = table.getEntry("tv");
    boolean TVboolean = tv.getDouble(0.0) == 1;
    if (!TVboolean) {
      if(m_defaultDirection == 0){
        Robot.m_DriveTrain.setLeftMotorBack(0);
        Robot.m_DriveTrain.setLeftMotorFront(0);
        Robot.m_DriveTrain.setRightMotorBack(0);
        Robot.m_DriveTrain.setRightMotorFront(0);
      }
      if(m_defaultDirection == -1){
        Robot.m_DriveTrain.setLeftMotorBack(0.3);
        Robot.m_DriveTrain.setLeftMotorFront(0.3);
        Robot.m_DriveTrain.setRightMotorBack(0.3);
        Robot.m_DriveTrain.setRightMotorFront(0.3);
      }
      if(m_defaultDirection == 1){
        Robot.m_DriveTrain.setLeftMotorBack(-0.3);
        Robot.m_DriveTrain.setLeftMotorFront(-0.3);
        Robot.m_DriveTrain.setRightMotorBack(-0.3);
        Robot.m_DriveTrain.setRightMotorFront(-0.3);
      }
      System.out.println("You do not hava a valid target");
    }
    else if (TVboolean) {
      System.out.println("You have a valid target");
      if (tx.getDouble(0.0) > 10) {
        // turn right
        // System.out.println("right0 " + tx);
        Robot.m_DriveTrain.setLeftMotorBack(0.3);
        Robot.m_DriveTrain.setLeftMotorFront(0.3);
        Robot.m_DriveTrain.setRightMotorBack(0.3);
        Robot.m_DriveTrain.setRightMotorFront(0.3);
      } else if (tx.getDouble(0.0) < -10) {
        // turn left
        // System.out.println("left0 "+ tx);
        Robot.m_DriveTrain.setLeftMotorBack(-0.3);
        Robot.m_DriveTrain.setLeftMotorFront(-0.3);
        Robot.m_DriveTrain.setRightMotorBack(-0.3);
        Robot.m_DriveTrain.setRightMotorFront(-0.3);
      } else if (tx.getDouble(0.0) >= -10 && tx.getDouble(0.0) <= 10) {

        if (tx.getDouble(0.0) > 5) {
          // turn right
          // System.out.println("right1 "+ tx);
          Robot.m_DriveTrain.setLeftMotorBack(0.15);
          Robot.m_DriveTrain.setLeftMotorFront(0.15);
          Robot.m_DriveTrain.setRightMotorBack(0.15);
          Robot.m_DriveTrain.setRightMotorFront(0.15);
        } else if (tx.getDouble(0.0) < -5) {
          // turn left
          // System.out.println("left1 "+ tx);
          Robot.m_DriveTrain.setLeftMotorBack(-0.15);
          Robot.m_DriveTrain.setLeftMotorFront(-0.15);
          Robot.m_DriveTrain.setRightMotorBack(-0.15);
          Robot.m_DriveTrain.setRightMotorFront(-0.15);
        } else if (tx.getDouble(0.0) >= -5 && tx.getDouble(0.0) <= 5) {

          if (tx.getDouble(0.0) > 3) {
            // turn right
            System.out.println("right");
            Robot.m_DriveTrain.setLeftMotorBack(0.1);
            Robot.m_DriveTrain.setLeftMotorFront(0.1);
            Robot.m_DriveTrain.setRightMotorBack(0.1);
            Robot.m_DriveTrain.setRightMotorFront(0.1);
          } else if (tx.getDouble(0.0) < -3) {
            // turn left
            System.out.println("left");
            Robot.m_DriveTrain.setLeftMotorBack(-0.1);
            Robot.m_DriveTrain.setLeftMotorFront(-0.1);
            Robot.m_DriveTrain.setRightMotorBack(-0.1);
            Robot.m_DriveTrain.setRightMotorFront(-0.1);
          } else if (tx.getDouble(0.0) >= -1.5 && tx.getDouble(0.0) <= 1.5) {

            if (tx.getDouble(0.0) > 0.3) {
              // turn right
              System.out.println("right");
              Robot.m_DriveTrain.setLeftMotorBack(0.05);
              Robot.m_DriveTrain.setLeftMotorFront(0.05);
              Robot.m_DriveTrain.setRightMotorBack(0.05);
              Robot.m_DriveTrain.setRightMotorFront(0.05);
            } else if (tx.getDouble(0.0) < -0.3) {
              // turn left
              System.out.println("left");
              Robot.m_DriveTrain.setLeftMotorBack(-0.05);
              Robot.m_DriveTrain.setLeftMotorFront(-0.05);
              Robot.m_DriveTrain.setRightMotorBack(-0.05);
              Robot.m_DriveTrain.setRightMotorFront(-0.05);
            }

          }

        } else {
          System.out.println("stop");
          Robot.m_DriveTrain.setLeftMotorBack(0.0);
          Robot.m_DriveTrain.setLeftMotorFront(0.0);
          Robot.m_DriveTrain.setRightMotorBack(0.0);
          Robot.m_DriveTrain.setRightMotorFront(0.0);
        }
      } 
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

}
