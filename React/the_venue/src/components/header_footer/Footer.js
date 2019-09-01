import React from 'react';
import Fade from 'react-reveal/Fade';

const Footer = () => {
    return (
        <footer className="bck_red">
            <Fade delay={300}>
                <div className="font_righteous footer_logo_venue">2019.08.27</div>
                <div className="footer_copyright">
                    포트폴리오
                </div>
            </Fade>
        </footer>
    );
};

export default Footer;