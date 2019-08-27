import React from 'react';

const Location = () => {
    return (
        <div className="location_wrapper">
            
            
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d12774.514027234534!2d126.54775563112744!3d33.452848995469694!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xf7f5abcddfe07e3b!2z7JWE65287Luo67Kk7IWY7ZmA!5e0!3m2!1sko!2skr!4v1566874051912!5m2!1sko!2skr"
             width="100%"
              height="450" 
              frameborder="0" 
              allowfullscreen>지도</iframe>
              

            <div className="location_tag">
                <div>위치</div>
            </div>

        </div>
    );
};

export default Location;