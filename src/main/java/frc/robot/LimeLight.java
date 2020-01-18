package frc.robot;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrain;

public class LimeLight extends TimedRobot{
   

    public static DriveTrain m_DriveTrain = new DriveTrain();

    NetworkTableInstance instance = NetworkTableInstance.getDefault();
  NetworkTable table = instance.getTable("limelight-limeboi");
  NetworkTable fms=instance.getTable("FMSInfo");
  NetworkTableEntry g=fms.getEntry("StationNumber");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");



    public void sendData(){
        System.out.println(ta.getDouble(5.5));
        System.out.println(tx.getDouble(6.6));
    }

    public void autoAdjust(){
        if(tx.getDouble(0.0) > 5){
            //turn right
            m_DriveTrain.setLeftMotorBack(5);
            m_DriveTrain.setLeftMotorFront(5);
            m_DriveTrain.setRightMotorBack(5);
            m_DriveTrain.setRightMotorFront(5);
        }else if(tx.getDouble(0.0) < -5){
            //turn left
            m_DriveTrain.setLeftMotorBack(-5);
            m_DriveTrain.setLeftMotorFront(-5);
            m_DriveTrain.setRightMotorBack(-5);
            m_DriveTrain.setRightMotorFront(-5);
        }
    }
}