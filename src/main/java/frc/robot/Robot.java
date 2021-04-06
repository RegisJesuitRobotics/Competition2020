/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.Drive;
import frc.robot.commands.CommandGroups.Auto;
import frc.robot.commands.CommandGroups.autoNavChallenge.BarrelRace;
import frc.robot.commands.CommandGroups.autoNavChallenge.Bounce;
import frc.robot.commands.CommandGroups.autoNavChallenge.GalacticSearch;
import frc.robot.commands.CommandGroups.autoNavChallenge.GalacticSearchARed;
import frc.robot.commands.CommandGroups.autoNavChallenge.GalacticSearchPickupRun;
import frc.robot.commands.CommandGroups.autoNavChallenge.Slalomn;
import frc.robot.commands.CommandGroups.autoNavChallenge.GalacticSearch.Routes;
import frc.robot.subsystems.BeltOnly;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShootWheels;
import frc.robot.subsystems.UpAndDown;
import frc.robot.subsystems.IntakeBar;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

public class Robot extends TimedRobot {
  
  public static OI m_oi;
  public static DriveTrain m_DriveTrain = new DriveTrain();
  public static ShootWheels m_Shooter = new ShootWheels();
  public static BeltOnly m_BeltOnly = new BeltOnly();
  public static UpAndDown m_UpAndDown = new UpAndDown();
  public static IntakeBar m_IntakeBar = new IntakeBar();
  public static Compressor compresor;
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
    
    PDP = new PowerDistributionPanel();

    m_oi = new OI();

    ballSensor = new DigitalInput(9);

    compresor = new Compressor();
    compresor.getPressureSwitchValue();

    m_chooser.addOption("Barrel Race", new BarrelRace());;
    m_chooser.addOption("Slalomn", new Slalomn());
    m_chooser.addOption("Bounce", new Bounce());
    m_chooser.addOption("Galactic Search", new GalacticSearch(this));
    
    SmartDashboard.putData("Auto mode", m_chooser);

  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putData("Gyro", m_DriveTrain.getGyro());
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
    if (m_chooser.getSelected() != null) {
      m_chooser.getSelected().schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
    // SmartDashboard.putNumber("TY(shoots best if between -10 and -11)", TY);
    // SmartDashboard.putNumber("TX(shoots best if between -1 and 1)", TX);
    // SmartDashboard.putBoolean("Valid Target?", TVboolean);

  }

  @Override
  public void teleopInit() {
    if (m_chooser.getSelected() != null) {
      m_chooser.getSelected().cancel();
    }  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("TY", TY);
    SmartDashboard.putNumber("TX", TX);
    SmartDashboard.putBoolean("Valid Target?", TVboolean);
    SmartDashboard.putNumber("Encoder distance", m_DriveTrain.getAverageEncoderDistance());
  }
  
  public Routes getRoute() {
    double heading = m_DriveTrain.getCompassHeading();
    if (heading > 25 && heading < 40) {
      return Routes.REDA;
    } 
    if (heading > 350 || heading < 10) {
      return Routes.BLUEA;
    }
    if (heading > 300 && heading < 320) {
      return Routes.REDB;
    }
    return Routes.BLUEB;
  }

  @Override
  public void testPeriodic() {
  }
}