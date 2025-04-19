import React, { useState } from "react";
import Box from '@mui/material/Box';
import { Avatar, Button } from "@mui/material";
import Modal from '@mui/material/Modal';
import VerifiedIcon from "@mui/icons-material/Verified";
import { useNavigate } from 'react-router-dom';
import { useFormik } from "formik";
import * as Yup from "yup";
import FmdGoodIcon from "@mui/icons-material/FmdGood";
import EmojiEmotionsIcon from "@mui/icons-material/EmojiEmotions";
import ImageIcon from "@mui/icons-material/Image";

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 600,
  bgcolor: 'background.paper',
  border: 'none',
  boxShadow: 24,
  p: 4,
  outline : 'none',
  borderRadius:4
};

export default function ReplyModal({handleClose,open}) {
    const [uploadingImage, setUploadingImage] = useState(false);
    const [selectedImage, setSelectedImage] = useState("");
  const navigate = useNavigate();
  const handleSubmit = (value) => {
    console.log("Values : ", value);
  };

  const handleSelectImage = (event) => {
    
    setUploadingImage(true);
  
    const file = event.target.files[0]; 
    if (file) {
      const imageUrl = URL.createObjectURL(file); 
      formik.setFieldValue("image", file); 
      setSelectedImage(imageUrl);
    }
    setUploadingImage(false);
  };

  const formik = useFormik({
    InitialValues: {
        content: "",
        image: "",
        twitId:4
        },
        onSubmit: handleSubmit
  });

  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
        <div className="flex items-center space-x-3">
        {" "}
        {/* Added space-x-3 for space between avatar and name */}
        <Avatar
          alt="username"
          src=""
          className="cursor-pointer"
          onClick={() => navigate(`/profile/${6}`)}
        />
        <div className="flex space-x-2">
          <span className="font-semibold cursor-pointer">Devansh Tyagi</span>
          <span className="text-gray-600 text-sm">@tyagidevansh . 2m</span>
          <VerifiedIcon className="text-[#E2B619]" />
        </div>
        
      </div>
      <section className="pb-10 mt-10">
        <div className="flex space-x-5">
          <Avatar alt="username" src="" />
          <div className="w-full">
            <form onSubmit={formik.handleSubmit}>
              <div>
                <input
                  type="text"
                  name="content"
                  placeholder="Post your reply"
                  className={`border-none outline-none text-xl bg-transparent`}
                  {...formik.getFieldProps("content")}
                ></input>
                {formik.errors.content && formik.touched.content && (
                  <span className="text-red-500">{formik.errors.content}</span>
                )}
              </div>
              {/* <div>
                        <img src="" alt="" />
                    </div> */}
              <div className="flex justify-between items-center mt-5">
                <div className="flex space-x-5 items-center">
                  <label className="flex items-center space-x-2 rounded-md cursor-pointer">
                    <ImageIcon className="text-[#1d9bf0]" />
                    <input
                      type="file"
                      name="imageFile"
                      className="hidden"
                      onChange={handleSelectImage}
                    />
                  </label>
                  <FmdGoodIcon className="text-[#1d9bf0]" />
                  <EmojiEmotionsIcon className="text-[#1d9bf0]" />
                </div>
                <div className="">
                  <Button
                    sx={{
                      width: "100%",
                      borderRadius: "30px",
                      paddingY: "5px",
                      paddingX: "20px",
                      bgcolor: "#1d9bf0",
                      
                    }}
                    variant="contained"
                    type="submit"
                  >
                    Post
                  </Button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </section>
        </Box>
      </Modal>
    </div>
  );
}
