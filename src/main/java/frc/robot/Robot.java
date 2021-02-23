/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.CommandGroups.Auto;
import frc.robot.subsystems.BeltOnly;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShootWheels;
import frc.robot.subsystems.UpAndDown;
import frc.robot.subsystems.IntakeBar;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ColorWheel;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

public class Robot extends TimedRobot {
  
  public static OI m_oi;
  public static DriveTrain m_DriveTrain;
  public static ShootWheels m_Shooter = new ShootWheels();
  public static BeltOnly m_BeltOnly = new BeltOnly();
  public static UpAndDown m_UpAndDown = new UpAndDown();
  public static IntakeBar m_IntakeBar = new IntakeBar();
  public static Climber m_Climber = new Climber();
  public static ColorWheel m_ColorWheel = new ColorWheel();
  // read values periodically
  NetworkTableInstance instance = NetworkTableInstance.getDefault();
  NetworkTable table = instance.getTable("limelight-limeboi");
  NetworkTable fms = instance.getTable("FMSInfo");
  NetworkTableEntry g = fms.getEntry("StationNumber");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry tv = table.getEntry("tv");
  boolean TVboolean = tv.getDouble(0.0) == 1;
  CommandBase m_autonomousCommand;
  double TX = tx.getDouble(0.0);
  double TY = ty.getDouble(0.0);
  PowerDistributionPanel PDP;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_autonomousCommand = new Auto();
    m_DriveTrain = new DriveTrain();
    m_oi = new OI();

    PDP = new PowerDistributionPanel();
    
    SmartDashboard.putData("Auto mode", m_chooser);

    SmartDashboard.putData("Auto mode", m_chooser);
  }

  @Override
  public void robotPeriodic() {
    
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
    // System.out.println("TOTAL CURRENT: " + PDP.getTotalCurrent());

  }

  @Override
  public void testPeriodic() {
  }
}
