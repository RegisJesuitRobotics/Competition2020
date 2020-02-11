// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands.LimelightStuff;

// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;

// public class LimeLightDriveAlignFineTune extends Command {
//   public LimeLightDriveAlignFineTune() {
//     // Use requires() here to declare subsystem dependencies align
//     // eg. requires(chassis);

//     requires(Robot.m_DriveTrain);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize() {
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   protected void execute() {
//     NetworkTableInstance instance = NetworkTableInstance.getDefault();
//     NetworkTable table = instance.getTable("limelight-limeboi");
//     NetworkTable fms = instance.getTable("FMSInfo");
//     NetworkTableEntry g = fms.getEntry("StationNumber");
//     NetworkTableEntry tx = table.getEntry("tx");
//     NetworkTableEntry tv = table.getEntry("tv");
//     boolean TVboolean = tv.getDouble(0.0) == 1;

//     if (TVboolean) {
//       System.out.println("You have a valid target");
//       if (tx.getDouble(0.0) > 0.6) {
//         // turn right
//         System.out.println("right");
//         Robot.m_DriveTrain.setLeftMotorBack(0.05);
//         Robot.m_DriveTrain.setLeftMotorFront(0.05);
//         Robot.m_DriveTrain.setRightMotorBack(0.05);
//         Robot.m_DriveTrain.setRightMotorFront(0.05);
//       } else if (tx.getDouble(0.0) < -0.6) {
//         // turn left
//         System.out.println("left");
//         Robot.m_DriveTrain.setLeftMotorBack(-0.05);
//         Robot.m_DriveTrain.setLeftMotorFront(-0.05);
//         Robot.m_DriveTrain.setRightMotorBack(-0.05);
//         Robot.m_DriveTrain.setRightMotorFront(-0.05);
//       } else {
//         System.out.println("stop");
//         Robot.m_DriveTrain.setLeftMotorBack(0.0);
//         Robot.m_DriveTrain.setLeftMotorFront(0.0);
//         Robot.m_DriveTrain.setRightMotorBack(0.0);
//         Robot.m_DriveTrain.setRightMotorFront(0.0);
//       }
//     } else {
//       System.out.println("You do not hava a valid target");
//     }
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   protected boolean isFinished() {
//     return false;
//   }

//   // Called once after isFinished returns true
//   @Override
//   protected void end() {
//   }

//   // Called when another command which requires one or more of the same
//   // subsystems is scheduled to run
//   @Override
//   protected void interrupted() {
//   }

// }
