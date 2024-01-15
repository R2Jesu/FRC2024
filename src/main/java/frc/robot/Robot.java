// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.PS4Controller;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  // defining drive here
  private final PS4Controller m_Drivestick = new PS4Controller(0);
  private final PS4Controller m_Operatorstick = new PS4Controller(1);
  
  // swerve 1
  private CANSparkMax m_SwerveDrive1 = new CANSparkMax(5, MotorType.kBrushless);
  private RelativeEncoder m_DriveEncoder1 = m_SwerveDrive1.getEncoder();
  private WPI_VictorSPX m_SwerveTurn1 = new WPI_VictorSPX(1);
  private AnalogInput m_SwerveAnalog1 = new AnalogInput(0);

  // swerve 2
  private CANSparkMax m_SwerveDrive2 = new CANSparkMax(6, MotorType.kBrushless);
  private RelativeEncoder m_DriveEncoder2 = m_SwerveDrive2.getEncoder();
  private WPI_VictorSPX m_SwerveTurn2 = new WPI_VictorSPX(2);
  private AnalogInput m_SwerveAnalog2 = new AnalogInput(1);

  // swerve 3
  private CANSparkMax m_SwerveDrive3 = new CANSparkMax(7, MotorType.kBrushless);
  private RelativeEncoder m_DriveEncoder3 = m_SwerveDrive3.getEncoder();
  private WPI_VictorSPX m_SwerveTurn3 = new WPI_VictorSPX(3);
  private AnalogInput m_SwerveAnalog3 = new AnalogInput(2);

  // swerve 4
  private CANSparkMax m_SwerveDrive4 = new CANSparkMax(8, MotorType.kBrushless);
  private RelativeEncoder m_DriveEncoder4 = m_SwerveDrive4.getEncoder();
  private WPI_VictorSPX m_SwerveTurn4 = new WPI_VictorSPX(4);
  private AnalogInput m_SwerveAnalog4 = new AnalogInput(3);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
