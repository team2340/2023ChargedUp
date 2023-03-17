package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch.Type;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

    private WPI_TalonSRX m_primaryAngle = new WPI_TalonSRX(4);
    private WPI_TalonSRX m_secondaryAngle = new WPI_TalonSRX(3);

    private CANSparkMax m_stage1 = new CANSparkMax(21, MotorType.kBrushless);
    private CANSparkMax m_stage2 = new CANSparkMax(20, MotorType.kBrushless);

    public Elevator(){

        // Configure arm angle motors
        m_secondaryAngle.follow(m_primaryAngle);
        m_primaryAngle.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
        m_primaryAngle.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);

        // Configure "stage 1" motor
        m_stage1.setInverted(true);
        m_stage1.getForwardLimitSwitch(Type.kNormallyOpen).enableLimitSwitch(true);
        m_stage1.getReverseLimitSwitch(Type.kNormallyOpen).enableLimitSwitch(true);
        m_stage1.burnFlash(); // MUST BE LAST

        // Configure "stage 2" motor
        m_stage2.setInverted(true);
        m_stage2.getForwardLimitSwitch(Type.kNormallyOpen).enableLimitSwitch(true);
        m_stage2.getReverseLimitSwitch(Type.kNormallyOpen).enableLimitSwitch(true);
        m_stage2.burnFlash(); // MUST BE LAST
    }

    public void changeAngle(double speed) {
        m_primaryAngle.set(speed);
    }

    public void moveStage1(double speed) {
        m_stage1.set(speed);
    }

    public void moveStage2(double speed) {
        m_stage2.set(speed);
    }
}
