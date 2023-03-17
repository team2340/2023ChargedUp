// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.motorcontrol.Talon;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


// public class DriveBase extends SubsystemBase {
//     WPI_TalonSRX m_leftFront = new WPI_TalonSRX(1);
//     WPI_TalonSRX m_leftRear = new WPI_TalonSRX(2);
//     WPI_TalonSRX m_rightFront = new WPI_TalonSRX(19);
//     WPI_TalonSRX m_rightRear = new WPI_TalonSRX(18);

//     //DifferentialDrive differentialDrive = new DifferentialDrive(m_leftFront, m_rightFront);
//     DifferentialDrive m_drive = new DifferentialDrive(m_leftFront, m_rightRear);

//     public void robotInit() {
//         // m_leftRear.set(ControlMode.Follower, 2);
//         // m_rightRear.set(ControlMode.Follower, 19);


//         m_leftRear.follow(m_leftFront);
//         m_rightFront.follow(m_rightRear);
//         m_leftFront.setInverted(true); // if you want to invert motor outputs, you must do so here
//     }

//     public double vBusMaxOutput = 1.0; //An output multiplier
// 	public double vBusPeakOutputVoltage = 1f; //the peak output (between 0 and 1)
	
//     public void setForVBus() {
// 		m_leftFront.set(ControlMode.PercentOutput,0);
//         m_rightRear.set(ControlMode.PercentOutput,0);
//         m_leftFront.configPeakOutputForward(vBusPeakOutputVoltage,0); 
// 	    m_leftFront.configPeakOutputReverse(-vBusPeakOutputVoltage,0);
// 	    m_rightRear.configPeakOutputForward(vBusPeakOutputVoltage,0);
// 	    m_rightRear.configPeakOutputReverse(-vBusPeakOutputVoltage,0);
// 		m_drive.setMaxOutput(vBusMaxOutput);
// 		// setBrakeMode(false);
// 	}

//     public void setArcadeSpeed(double x, double y){
//         setForVBus();
// 		m_drive.arcadeDrive(-y, x);
//         //m_drive.setArcadeSpeed(x, y);

// 	}
// }


// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import frc.robot.Constants;
// import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends SubsystemBase {

  private WPI_TalonSRX m_rightFront = new WPI_TalonSRX(19);
  private WPI_TalonSRX m_rightBack = new WPI_TalonSRX(18);
  private WPI_TalonSRX m_leftFront = new WPI_TalonSRX(1);
  private WPI_TalonSRX m_leftBack = new WPI_TalonSRX(2);

  private DifferentialDrive m_robotDrive;
  /** Creates a new ExampleSubsystem. */
  public DriveBase() {

    m_leftBack.follow(m_leftFront);
    m_rightBack.follow(m_rightFront);

    m_rightFront.setInverted(true);
    m_rightBack.setInverted(true);


    m_leftFront.setNeutralMode(NeutralMode.Brake);
    m_leftBack.setNeutralMode(NeutralMode.Brake);
    m_rightFront.setNeutralMode(NeutralMode.Brake);
    m_rightBack.setNeutralMode(NeutralMode.Brake);

    m_robotDrive = new DifferentialDrive(m_leftFront, m_rightFront);
  }

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//     double left = OI.getXboxLeftJoystickY();
//     double right = OI.getXboxRightJoystickY();

//     m_robotDrive.tankDrive(left, right, true);
//   }

  public void drive(double x, double y){
    m_robotDrive.arcadeDrive(x, y);
    // m_robotDrive.tankDrive(left, right, true);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}