package frc.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class PlaystationController extends Joystick {

    public final double thumbStickDeadzone = 0.1;
    
    public final JoystickButton square = new JoystickButton(this, 1);
    public final JoystickButton x = new JoystickButton(this, 2);
    public final JoystickButton circle = new JoystickButton(this, 3);
    public final JoystickButton triangle = new JoystickButton(this, 4);

    public final JoystickButton leftButton = new JoystickButton(this, 5);
    public final JoystickButton rightButton = new JoystickButton(this, 6);
    public final Trigger leftTrigger = new Trigger(this, 7, 3);
    public final Trigger rightTrigger = new Trigger(this, 8, 4);

    public final JoystickButton share = new JoystickButton(this, 9);
    public final JoystickButton options = new JoystickButton(this, 10);

    public final ThumbStick leftThumb = new ThumbStick(this, 11, 0, 1);
    public final ThumbStick rightThumb = new ThumbStick(this, 12, 2, 5);

    public final JoystickButton playstationButton = new JoystickButton(this, 13);
    public final JoystickButton touchpad = new JoystickButton(this, 14);

    public final DPad dPad = new DPad(this);

    /**
     * Construct an instance of a joystick. The joystick index is the USB port on
     * the drivers station.
     *
     * @param port The port on the Driver Station that the joystick is plugged into.
     */
    public PlaystationController(int port) {
        super(port);
    }

    public static class Trigger extends Button {
        private final int axisPort;
        private final Joystick parent;

        public Trigger(Joystick parent, int buttonNumber, int axisPort) {
            this.parent = parent;
            this.axisPort = axisPort;
        }

        @Override
        public boolean get() {
            return getAxis() > 0.6;
        }

        public double getAxis() {
            return parent.getRawAxis(axisPort);
        }
    }

    public static class ThumbStick extends JoystickButton {
        private final int xAxisPort;
        private final int yAxisPort;

        private final Joystick parent;

        public ThumbStick(Joystick parent, int buttonNumber, int xAxisPort, int yAxisPort) {
            super(parent, buttonNumber);
            this.parent = parent;
            this.xAxisPort = xAxisPort;
            this.yAxisPort = yAxisPort;
        }

        public double getXAxis() {
            return parent.getRawAxis(xAxisPort);
        }

        public double getYAxis() {
            return -parent.getRawAxis(yAxisPort);
        }
    }

    public static class DPad {
        public final Joystick parent;
        public final DPadButton up = new DPadButton(this, DPadDirection.UP);
        public final DPadButton down = new DPadButton(this, DPadDirection.DOWN);
        public final DPadButton left = new DPadButton(this, DPadDirection.LEFT);
        public final DPadButton right = new DPadButton(this, DPadDirection.RIGHT);

        public DPad(Joystick parent) {
            this.parent = parent;
        }

        public int angle() {
            return parent.getPOV();
        }

        public enum DPadDirection {
            UP(0), RIGHT(90), DOWN(180), LEFT(270);

            public int angle;

            DPadDirection(int angle) {
                this.angle = angle;
            }
        }

        public static class DPadButton extends Button {
            public final DPad parent;
            private final DPadDirection direction;

            public DPadButton(DPad parent, DPadDirection direction) {
                this.parent = parent;
                this.direction = direction;
            }

            @Override
            public boolean get() {
                return parent.angle() == direction.angle;
            }
        }
    }

}