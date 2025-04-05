import { Avatar, Button, Input } from "@mui/material";
import { useFormik } from "formik";
import React, { useState } from "react";
import * as Yup from "yup";
import ImageIcon from "@mui/icons-material/Image";
import FmdGoodIcon from "@mui/icons-material/FmdGood";
import EmojiEmotionsIcon from "@mui/icons-material/EmojiEmotions";
import TweetCard from "./TweetCard";

export default function HomeSection() {
  const [uploadingImage, setUploadingImage] = useState(false);
  const [selectedImage, setSelectedImage] = useState("");

  const validationSchema = Yup.object().shape({
    content: Yup.string().required("Text is Required"),
  });

  const handleSubmit = (value) => {
    console.log("Values : ", value);
  };

  const formik = useFormik({
    initialValues: {
      content: "",
      image: "",
    },
    onSubmit: handleSubmit,
    validationSchema,
  });

  const handleSelectImage = (event) => {
    setUploadingImage(true);
  
    const file = event.target.files[0]; 
    if (file) {
      const imageUrl = URL.createObjectURL(file); // Generate a preview URL
      formik.setFieldValue("image", file); // Store the file object
      setSelectedImage(imageUrl);
    }
  
    setUploadingImage(false);
  };
  return (
    <div className="space-y-5">
      <section>
        <h1 className="py-5 text-xl font-bold opacity-90">Home</h1>
      </section>
      <section className="pb-10 ">
        <div className="flex space-x-5">
          <Avatar alt="username" src="" />
          <div className="w-full">
            <form onSubmit={formik.handleSubmit}>
              <div>
                <input
                  type="text"
                  name="content"
                  placeholder="Share your Thoughts"
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
                <div>
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
      <section className="">
        {[1,1,1,1,1].map((item) => <TweetCard/>)}
            
      </section>
    </div>
  );
}
