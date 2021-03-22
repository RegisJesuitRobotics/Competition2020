/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.Drive;
import frc.robot.commands.CommandGroups.Auto;
import frc.robot.subsystems.BeltOnly;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShootWheels;
import frc.robot.subsystems.UpAndDown;
import frc.robot.subsystems.IntakeBar;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import java.util.List;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

public class Robot extends TimedRobot {
  
  public static OI m_oi;
  public static DriveTrain m_DriveTrain = new DriveTrain();
  public static ShootWheels m_Shooter = new ShootWheels();
  public static BeltOnly m_BeltOnly = new BeltOnly();
  public static UpAndDown m_UpAndDown = new UpAndDown();
  public static IntakeBar m_IntakeBar = new IntakeBar();
  // read values periodically
  NetworkTableInstance instance = NetworkTableInstance.getDefault();
  NetworkTable table = instance.getTable("limelight-limeboi");
  NetworkTable fms = instance.getTable("FMSInfo");
  NetworkTableEntry g = fms.getEntry("StationNumber");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry tv = table.getEntry("tv");
  boolean TVboolean = tv.getDouble(0.0) == 1;
  DigitalInput ballSensor;
  CommandBase m_autonomousCommand;
  double TX = tx.getDouble(0.0);
  double TY = ty.getDouble(0.0);
  PowerDistributionPanel PDP;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_DriveTrain.setDefaultCommand(new Drive());
    m_autonomousCommand = new Auto();
    
    PDP = new PowerDistributionPanel();

    m_oi = new OI();

    ballSensor = new DigitalInput(9);
    
    SmartDashboard.putData("Auto mode", m_chooser);

  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putData("Sensor value", ballSensor);
    SmartDashboard.putNumberArray("Starting Distances", listToArray(AutoMoveDistance.startingDistances));
    SmartDashboard.putNumberArray("Ending Distances", listToArray(AutoMoveDistance.endingDistances));
  }

  private Double[] listToArray(List<Double> list) {
    Double[] array = new Double[list.size()];
    return list.toArray(array);
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("TY(shoots best if between -10 and -11)", TY);
    SmartDashboard.putNumber("TX(shoots best if between -1 and 1)", TX);
    SmartDashboard.putBoolean("Valid Target?", TVboolean);

  }

  @Override
  public void teleopInit() {
    m_autonomousCommand.cancel();
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("TY", TY);
    SmartDashboard.putNumber("TX", TX);
    SmartDashboard.putBoolean("Valid Target?", TVboolean);
    SmartDashboard.putNumber("Encoder distance", m_DriveTrain.getAverageEncoderDistance());
    SmartDashboard.putNumber("Encoder differance", m_DriveTrain.getDifferenceInEncoderDistance());
    SmartDashboard.putNumber("Gyro rotate", m_DriveTrain.getGyro().getRotation2d().getDegrees());
  }

  @Override
  public void testPeriodic() {
  }
}